package ru.yura.web.service;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.yura.web.model.User;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;
    private final String serverUrl;

    public UserServiceImpl(
            RestTemplate restTemplate
    ) {
        this.restTemplate = restTemplate;
        this.serverUrl = "http://localhost:8080/";
    }

    public User findModelByNames(String name) {

        User user = restTemplate.getForObject(
                "http://localhost:8080/checkUser",
                User.class);
        return user;
    }


    @Override
    public List<User> findAll() {
        User[] list = restTemplate.getForObject(serverUrl + "admin/admin", User[].class);
        List<User> users = Arrays.asList(list);
        System.out.println("users -" + users);
        return users;
    }


    @Override
    public User delete(User model) {
        HttpEntity<User> requestBody = new HttpEntity<>(model);
        ResponseEntity<Employee> result
                = restTemplate.postForEntity(URL_CREATE_EMPLOYEE, requestBody, Employee.class);





        User user = restTemplate.postForObject(serverUrl + "admin/delete", requestBody, User.class);
        return user;
    }


    @Override
    public User update(User model, Long[] ids) {
        HttpEntity<User> requestBody = new HttpEntity<>(model);
        return model;
    }
//
////    @Autowired
////    private final String serverUrl;
//
//
//    @Transactional
//    @Override
//    public void add(User model, Long id) {
//        userDao.add(model);
//        model.addRoles(roleDao.findById(id));
//    }
//
//    @Transactional
//    @Override
//    public User update(User model, Long[] ids) {
//        User user = userDao.update(model);
//        insideRoles(user, ids);
//        return user;
//    }
//
//    private void insideRoles(User model, Long[] ids) {
//        List<Role> newRoles = new ArrayList<>();
//        for (Long id : ids) {
//            Role role = roleDao.findById(id);
//            newRoles.add(role);
//        }
//        model.setRoles(newRoles);
//    }
//
//    @Transactional(readOnly = true)
//    @Override
//    public User findModelByName(String name) {
//        return userDao.findModelByName(name);
//    }
//

//    @Transactional(readOnly = true)
//    @Override
//    public User findById(Long id) {
//
//        return userDao.findById(id);
//    }
//

//
//
//    @Override
//    public void drop() {
//        userDao.drop();
//    }
//
//
//    @Override
//    public void create() {
//        userDao.create();
//    }


    @Override
    public User findById(Long id) {
        return null;
    }


    @Override
    public void drop() {

    }

    @Override
    public void create() {

    }

    @Override
    public void add(User model, Long ids) {

    }

    @Override
    public User findModelByName(String name) {
        return null;
    }

}
