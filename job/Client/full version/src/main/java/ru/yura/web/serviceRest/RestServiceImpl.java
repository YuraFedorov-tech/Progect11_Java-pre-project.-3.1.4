package ru.yura.web.serviceRest;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.yura.web.app.config.ConfigProperties;
import ru.yura.web.model.Role;
import ru.yura.web.model.User;

import java.util.Arrays;
import java.util.List;

@Service
public class RestServiceImpl implements RestService {
    final
    ConfigProperties configProp;

    private final RestTemplate restTemplate;
    private final String serverUrl;

    public RestServiceImpl(
            RestTemplate restTemplate,
            ConfigProperties configProp) {
        this.restTemplate = restTemplate;
        this.serverUrl = configProp.getConfigValue("server.db.host") + configProp.getConfigValue("server.db.port");
        this.configProp = configProp;
    }


    @Override
    public List<User> findAll() {
        User[] list = restTemplate.getForObject(serverUrl + configProp.getConfigValue("findAll"), User[].class);
        List<User> users = Arrays.asList(list);
        return users;
    }


    @Override
    public User delete(User model) {
        HttpEntity<User> requestBody = new HttpEntity<>(model);
        ResponseEntity<User> responseEntity
                = restTemplate.exchange(serverUrl + configProp.getConfigValue("delete"), HttpMethod.POST, requestBody, User.class);
        return responseEntity.getBody();

    }

    @Override
    public User add(User model, Long ids) {
        HttpEntity<User> requestBody = new HttpEntity<>(model);
        ResponseEntity<User> responseEntity
                = restTemplate.exchange(serverUrl + configProp.getConfigValue("add") + Long.toString(ids), HttpMethod.POST, requestBody, User.class);
        return responseEntity.getBody();
    }

    @Override
    public User update(User model, Long[] ids) {

        for (Long id : ids) {
            model.addRoles(new Role().setId(id));
        }
        HttpEntity<User> requestBody = new HttpEntity<>(model);
        ResponseEntity<User> responseEntity
                = restTemplate.exchange(serverUrl + configProp.getConfigValue("update"), HttpMethod.POST, requestBody, User.class);
        return responseEntity.getBody();
    }

    @Override
    public User findById(Long id) {
        return restTemplate.getForObject(serverUrl + configProp.getConfigValue("findById") + id, User.class);
    }

    @Override
    public User findModelByName(String name) {
        int y=0;
        return restTemplate.getForObject(serverUrl + configProp.getConfigValue("findModelByName") + name, User.class);

    }

    @Override
    public void drop() {
    }

    @Override
    public void create() {
    }
}