package com.stackfing.handgo.admin.service.serviceImpl;

import com.stackfing.handgo.admin.entity.User;
import com.stackfing.handgo.admin.mapper.UserMapper;
import com.stackfing.handgo.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUserByStatusIs(int status) {
//        return userRepository.findUserByStatusIs(1);
        return null;
    }

//    @Override
//    public UserLocate findParmiry(Long uid) {
////        return userLocateRepository.findUserLocateByIsPrimary(uid);
//        return null;
//    }

	@Override
	public List<User> selectAllUser() {
		return userMapper.findAll();
	}

	@Override
	public User selectUserById(Long uid) {
//		return userMapper.findOne(uid);
		return userMapper.selectUserById(uid);
    }

	@Override
	public void saveUser(User user) {
//		userMapper.save(user);
    }

	@Override
	public int deleteUserById(Long uid) {
		return userMapper.deleteUserById(uid);
	}

	@Override
	public List<User> selectAllUserByPage(Long page) {
    	Long length = 10L;
    	List<User> list = null;
    	if (page == 1) {
			list = userMapper.selectAllUserByPage(0L, length);
		} else {
			list = userMapper.selectAllUserByPage((length * page) - (length - 1), length);
		}
		return list;
	}

	@Override
	public List<User> selectAllDeletedUserByPage(Long page) {
		Long length = 10L;
		List<User> list = null;
		if (page == 1) {
			list = userMapper.selectAllDeletedUserByPage(0L, length);
		} else {
			list = userMapper.selectAllDeletedUserByPage((length * page) - (length - 1), length);
		}
		return list;
	}
}
