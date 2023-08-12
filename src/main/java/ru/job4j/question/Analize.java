package ru.job4j.question;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Info info = new Info(0, 0, 0);
        Map<Integer, String> map = current.stream()
                .collect(Collectors.toMap(User::getId, User::getName));
        for (User user : previous) {
            if (map.get(user.getId()) == null) {
                info.setDeleted(info.getDeleted() + 1);
            } else if (!map.get(user.getId()).equals(user.getName())) {
                info.setChanged(info.getChanged() + 1);
                map.remove(user.getId());
            } else {
                map.remove(user.getId());
            }
        }
        info.setAdded(info.getAdded() + map.size());
        return info;
    }

}