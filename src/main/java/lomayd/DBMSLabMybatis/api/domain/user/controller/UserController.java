package lomayd.DBMSLabMybatis.api.domain.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lomayd.DBMSLabMybatis.api.domain.user.dto.UserRequestDto;
import lomayd.DBMSLabMybatis.api.domain.user.dto.UserResponseDto;
import lomayd.DBMSLabMybatis.api.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // SQL Annotation Version
    
    @PostMapping
    public ResponseEntity<Void> joinUser(@RequestBody UserRequestDto.UserJoin userJoin) {
        userService.joinUser(userJoin);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<UserResponseDto.UserInfo> getUser(@RequestParam String id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PatchMapping
    public ResponseEntity<Void> modifyUser(@RequestParam String id, @RequestBody UserRequestDto.UserModify userModify) {
        userService.modifyUser(id, userModify);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> removeUser(@RequestParam String id) {
        userService.removeUser(id);
        return ResponseEntity.ok().build();
    }
    
    // XML Mapper Version
    
    @PostMapping("/xml")
    public ResponseEntity<Void> joinUserXml(@RequestBody UserRequestDto.UserJoin userJoin) {
        userService.joinUserXml(userJoin);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/xml")
    public ResponseEntity<UserResponseDto.UserInfo> getUserXml(@RequestParam String id) {
        return ResponseEntity.ok(userService.getUserXml(id));
    }

    @PatchMapping("/xml")
    public ResponseEntity<Void> modifyUserXml(@RequestParam String id, @RequestBody UserRequestDto.UserModify userModify) {
        userService.modifyUserXml(id, userModify);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/xml")
    public ResponseEntity<Void> removeUserXml(@RequestParam String id) {
        userService.removeUserXml(id);
        return ResponseEntity.ok().build();
    }
}
