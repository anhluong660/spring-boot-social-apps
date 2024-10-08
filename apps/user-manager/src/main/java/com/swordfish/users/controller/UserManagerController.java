package com.swordfish.users.controller;

import com.swordfish.users.dto.response.ResFriendInfo;
import com.swordfish.users.dto.response.ResUserInfo;
import com.swordfish.users.service.UserManagerService;
import com.swordfish.utils.common.RequestContextUtil;
import com.swordfish.utils.dto.GeneralListResponse;
import com.swordfish.utils.dto.GeneralResponse;
import com.swordfish.utils.enums.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class UserManagerController {

    @Autowired
    private UserManagerService userManagerService;

    @GetMapping("/user-info")
    public GeneralResponse<ResUserInfo> getUserInfo() {
        long userId = RequestContextUtil.getUserId();
        ResUserInfo resUserInfo = userManagerService.getUserInfo(userId);
        if (resUserInfo == null) {
            return GeneralResponse.of(ErrorCode.USER_INFO_NULL);
        }

        return GeneralResponse.success(resUserInfo);
    }

    @GetMapping("/user-info/{userId}")
    public GeneralResponse<ResUserInfo> getUserInfoById(@PathVariable Long userId) {
        ResUserInfo resUserInfo = userManagerService.getUserInfo(userId);
        if (resUserInfo == null) {
            return GeneralResponse.of(ErrorCode.USER_INFO_NULL);
        }

        return GeneralResponse.success(resUserInfo);
    }

    @GetMapping("/user-info-list")
    public GeneralListResponse<ResUserInfo> getUserInfoList(@RequestBody List<Long> userIds) {
        if (userIds == null || userIds.isEmpty()) {
            return GeneralListResponse.of(ErrorCode.PARAMS_INVALID);
        }

        List<ResUserInfo> resUserInfoList = userManagerService.getUserInfoList(userIds);
        return GeneralListResponse.success(resUserInfoList);
    }

    @PostMapping("/add-friend/{friendId}")
    public GeneralResponse<String> addFriend(@PathVariable Long friendId) {
        long userId = RequestContextUtil.getUserId();

        if (Objects.equals(friendId, userId)) {
            return GeneralResponse.fail();
        }

        if (!userManagerService.existUserById(friendId)) {
            return GeneralResponse.of(ErrorCode.ACCOUNT_NOT_EXIST);
        }

        ErrorCode error = userManagerService.addFriend(userId, friendId);
        return GeneralResponse.of(error);
    }

    @PostMapping("/remove-friend/{friendId}")
    public GeneralResponse<String> removeFriend(@PathVariable Long friendId) {
        long userId = RequestContextUtil.getUserId();

        if (Objects.equals(friendId, userId)) {
            return GeneralResponse.fail();
        }

        if (!userManagerService.existUserById(friendId)) {
            return GeneralResponse.of(ErrorCode.ACCOUNT_NOT_EXIST);
        }

        ErrorCode error = userManagerService.removeFriend(userId, friendId);
        return GeneralResponse.of(error);
    }

    @GetMapping("/friends")
    public GeneralListResponse<ResFriendInfo> getAllFriend() {
        long userId = RequestContextUtil.getUserId();
        List<ResFriendInfo> listRes = userManagerService.getAllFriend(userId);
        return GeneralListResponse.success(listRes);
    }

    @GetMapping("/inviters")
    public GeneralListResponse<ResFriendInfo> getAllInviter() {
        long userId = RequestContextUtil.getUserId();
        List<ResFriendInfo> listRes = userManagerService.getAllInviter(userId);
        return GeneralListResponse.success(listRes);
    }
}
