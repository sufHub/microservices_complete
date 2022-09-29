package com.suf.user.service;

import com.suf.user.VO.Department;
import com.suf.user.VO.ResponseTemplateVO;
import com.suf.user.entity.User;
import com.suf.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        return userRepository.save(user);
    }


    public ResponseTemplateVO getUserWithDepartment(Long userID) {

        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userID);

        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/"+user.getDepartmentId()
                , Department.class);

        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);

        return responseTemplateVO;
    }
}
