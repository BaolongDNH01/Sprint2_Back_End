package com.example.sprint2be.service.user.impl;

import com.example.sprint2be.model.Rank;
import com.example.sprint2be.model.Role;
import com.example.sprint2be.model.payment.Cart;
import com.example.sprint2be.model.user.User;
import com.example.sprint2be.model.user.UserDto;
import com.example.sprint2be.repository.RoleRepository;
import com.example.sprint2be.repository.UserRepository;
import com.example.sprint2be.service.rank.RankService;
import com.example.sprint2be.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RankService rankService;
    private User convertToUser(UserDto userDto){
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setFullName(userDto.getFullName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setBirthday(userDto.getBirthday());
        user.setAddress(userDto.getAddress());
        user.setIdCard(userDto.getIdCard());
        user.setPoint(userDto.getPoint());
        user.setSignInRecent(userDto.getSignInRecent());
        user.setFlag(userDto.getFlag());
        user.setAvatar("https://firebasestorage.googleapis.com/v0/b/real-estate-d8b23.appspot.com/o/mWBlKu8IIggRNhyUutW8?alt=media&token=7f0c3569-e638-4160-bdb5-28cf4dfe22eb");
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findById(2).orElse(null));
        user.setRoles(roles);
        List<Rank> ranks = rankService.findAll();
        Rank newUserRank = rankService.findById(1);
        user.setRank(newUserRank);
//        for (Rank rank: ranks){
//            if (rank.getName().equals(userDto.getRank())) {
//                newUserRank = rankService.findById(rank.getRankId());
//                user.setRank(newUserRank);
//            }
//        }
        user.setConfirmPassword(userDto.getConfirmPassword());
        user.setEnabled(userDto.getEnabled());

        // Thien: Add cart when user is created
        Cart cart = new Cart();
        cart.setShipCost(30000.0);
        cart.setTotalPrice(0.0);
        cart.setStatus(true);

        user.setCart(cart);
        cart.setShipCost(30000.0);
        cart.setTotalPrice(0.0);
        cart.setStatus(true);

        return user;
    }
    @Override
    public UserDto convertToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setFullName(user.getFullName());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setBirthday(user.getBirthday());
        userDto.setAddress(user.getAddress());
        userDto.setIdCard(user.getIdCard());
        userDto.setPoint(user.getPoint());
        userDto.setSignInRecent(user.getSignInRecent());
        userDto.setFlag(user.getFlag());
        userDto.setAvatar(user.getAvatar());
        userDto.setRank(user.getRank().getName());
        userDto.setConfirmPassword(user.getConfirmPassword());
        userDto.setEnabled(user.getEnabled());
        return userDto;
    }


    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public Optional<User> findUserById(Integer id) {
        return userRepository.findById(id);
    }


        @Override
    public Boolean checkUsernameExist(String username) {
        return (userRepository.findByUsername(username).orElse(null) != null);
    }

    @Override
    public Boolean changePassword(Integer id, String password) {
        Optional<User> checkExist = findUserById(id);
        if (checkExist.isPresent()){
            User user = checkExist.get();
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(password));
            userRepository.save(user);
            return true;
        }else return false;
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(this::convertToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Integer id) {
        return (userRepository.findById(id)).map(this::convertToUserDto).orElse(null);
    }

    @Override
    public User findByIdUser(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void create(UserDto userDto) {

        userRepository.save(convertToUser(userDto));
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void lockUser(List<UserDto> userDtoList) {
        for (UserDto userDto: userDtoList){
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    userDto.setFlag("true");
                    userDto.setPoint(0);
                    userDto.setRank("Đồng");
                    userRepository.save(convertToUser(userDto));
                }
            };
//        1000 time = 1s
            userDto.setFlag("false");
            userRepository.save(convertToUser(userDto));
            Timer timer = new Timer();
            timer.schedule(timerTask, userDto.getTimeLock());
        }
    }

    @Override
    public UserDto getUserByUserName(String userName) {
        return userRepository.findByUsername(userName).map(this::convertToUserDto).orElse(null);
    }

    @Override
    public void editUser(UserDto userEdit, String userName) {
        User user = userRepository.findByUsername(userName).orElse(null);
        if(user != null){
            user.setUsername(userEdit.getUsername());
            user.setFullName(userEdit.getFullName());
            user.setEmail(userEdit.getEmail());
            user.setBirthday(userEdit.getBirthday());
            user.setIdCard(userEdit.getIdCard());
            user.setPassword(userEdit.getPassword());
            user.setAddress(userEdit.getAddress());
            user.setPhone(userEdit.getPhone());
            userRepository.save(user);
        }
    }
    @Override
    public UserDto findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return convertToUserDto(user);
    }

    @Override

    public boolean isCorrectConfirmPassword(UserDto userDto) {
        User user = convertToUser(userDto);
        boolean isCorrectConfirmPassword = false;

        if (user.getPassword().equals(user.getConfirmPassword())) {

            isCorrectConfirmPassword = true;

        }

        return isCorrectConfirmPassword;

    }

    @Override
    public UserDto findTopById() {
        return convertToUserDto(userRepository.findTopByOrderByUserIdDesc());
    }

    @Override
    public List<UserDto> findAllUserActivated() {
        return userRepository.findAllUserActivated().stream().map(this::convertToUserDto).collect(Collectors.toList());
    }

    @Override
    public void unlockUser(List<UserDto> userDtoList) {
        for (UserDto userDto: userDtoList){
            userDto.setFlag("true");
            userRepository.save(convertToUser(userDto));
        }
    }
    @Override
    public void deleteUser(List<String> ids) {
        for (String id: ids){
            userRepository.deleteById(Integer.parseInt(id));
        }
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

}

