package ru.mirea.fedulovama.myarticleapp.domain.usecases;

import ru.mirea.fedulovama.myarticleapp.domain.models.User;
import ru.mirea.fedulovama.myarticleapp.domain.repository.UserRepository;

public class ChangeUserInfoUseCase {
    private UserRepository userRepository;
    public ChangeUserInfoUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public Boolean execute(User user){
        return this.userRepository.changeUserInfo(user);
    }
}
