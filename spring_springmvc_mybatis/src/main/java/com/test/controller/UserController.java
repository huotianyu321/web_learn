package com.test.controller;

import com.test.controller.common.ApiResult;
import com.test.controller.common.ResultEnum;
import com.test.pojo.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @Controller
// @ResponseBody
/*RestController这个注解包含上边两个内容，可以两种方式选一个*/
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    /*============下面的请求方式使用RESTful风格=============*/

    /*查 : Get方法，查一个带路径参数，查多个不带参数*/
    // @RequestMapping(value = "", method = RequestMethod.GET)
    // 或：
    @GetMapping("")
    public ApiResult<List<User>> findList() {
        List<User> userList = userService.findList();
        if (userList.isEmpty()) {
            return new ApiResult<>(ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMsg(), null);
        }
        return new ApiResult<>(userList);
    }

    // @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    // 或：
    @GetMapping("/{id}")
    public ApiResult<User> findById(@PathVariable Integer id) {
        User user = userService.findById(id);
        if (user == null) {
            return new ApiResult<>(ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMsg(), null);
        }
        return new ApiResult<>(user);
    }

    /*增： Post方法，携带请求体*/
    // @RequestMapping(value = "", method = RequestMethod.POST)
    // 或：
    @PostMapping("")
    public ApiResult save(@RequestBody User user) {
        userService.saveOne(user);
        return ApiResult.success();
    }

    /* 删： Delete方法，携带路径参数*/
    // @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    // 或：
    @DeleteMapping("/{id}")
    public ApiResult deleteById(@PathVariable Integer id) {
        userService.deleteById(id);
        return ApiResult.success();
    }

    /* 改： Put方法，携带请求体*/
    // @RequestMapping(value = "", method = RequestMethod.PUT)
    // 或：
    @PutMapping("")
    public ApiResult update(@RequestBody User user) {
        userService.updateOne(user);
        return ApiResult.success();
    }

}
