package lomayd.DBMSLabMybatis.api.domain.user.service;

import org.springframework.stereotype.Service;

import lomayd.DBMSLabMybatis.api.domain.user.User;
import lomayd.DBMSLabMybatis.api.domain.user.dto.UserRequestDto;
import lomayd.DBMSLabMybatis.api.domain.user.dto.UserResponseDto;
import lomayd.DBMSLabMybatis.api.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // SQL Annotation Version
    
    public void joinUser(UserRequestDto.UserJoin userJoin){
        User user = User.builder()
                .id(userJoin.getId())
                .password(userJoin.getPassword())
                .name(userJoin.getName())
                .nickname(userJoin.getNickname())
                .email(userJoin.getEmail())
                .age(userJoin.getAge())
                .build();

        userRepository.save(user);
    }

    public UserResponseDto.UserInfo getUser(String id) {
        User user = userRepository.findById(id);

        return UserResponseDto.UserInfo.of(user);
    }

    public void modifyUser(String id, UserRequestDto.UserModify userModify) {
        User user = userRepository.findById(id);

        user.setPassword(userModify.getPassword());
        user.setName(userModify.getName());
        user.setNickname(userModify.getNickname());
        user.setEmail(userModify.getEmail());
        user.setAge(userModify.getAge());

        userRepository.update(id, user);
    }
    public void removeUser(String id) {
        userRepository.deleteById(id);
    }
    
    // XML Mapper Version
    
    public void joinUserXml(UserRequestDto.UserJoin userJoin){
        User user = User.builder()
                .id(userJoin.getId())
                .password(userJoin.getPassword())
                .name(userJoin.getName())
                .nickname(userJoin.getNickname())
                .email(userJoin.getEmail())
                .age(userJoin.getAge())
                .build();

        userRepository.saveXml(user);
    }

    public UserResponseDto.UserInfo getUserXml(String id) {
        User user = userRepository.findByIdXml(id);

        return UserResponseDto.UserInfo.of(user);
    }

    public void modifyUserXml(String id, UserRequestDto.UserModify userModify) {
        User user = userRepository.findByIdXml(id);

        user.setPassword(userModify.getPassword());
        user.setName(userModify.getName());
        user.setNickname(userModify.getNickname());
        user.setEmail(userModify.getEmail());
        user.setAge(userModify.getAge());

        userRepository.updateXml(id, user);
    }
    public void removeUserXml(String id) {
        userRepository.deleteByIdXml(id);
    }
}
