package ru.vdn.example3_sem3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vdn.example3_sem3.domain.User;

@Service
public class RegistrationService {
    @Autowired
    private DataProcessingService dataProcessingService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    //Поля UserService, NotificationService
    @Autowired
    private UserService userService;

    @Autowired
    public NotificationService notificationService;


    //Метод processRegistration
    public void processRegistration(String name, int age, String email){
        User userNew = userService.createUser(name, age, email);
        dataProcessingService.getRepository().getUsers().add(userNew);
        notificationService.notify(userNew);
    }



}
