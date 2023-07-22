package ru.job4j.generics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {

    @Test
    void whenAddRole() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Admin"));
        Role result = roleStore.findById("1");
        assertThat(result.getRole()).isEqualTo("Admin");
    }

    @Test
    void whenAddRoleThenNull() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Admin"));
        Role result = roleStore.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddRoleAdminAndUserThenAdmin() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Admin"));
        roleStore.add(new Role("1", "User"));
        Role result = roleStore.findById("1");
        assertThat(result.getRole()).isEqualTo("Admin");
    }

    @Test
    void whenReplaceAdminToUserThenUser() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Admin"));
        roleStore.replace("1", new Role("1", "User"));
        Role result = roleStore.findById("1");
        assertThat(result.getRole()).isEqualTo("User");
    }

    @Test
    void whenReplaceThenFalse() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Admin"));
        boolean result = roleStore.replace("2", new Role("2", "User"));
        assertThat(result).isFalse();
    }

    @Test
    void whenDeleteRoleThenIsTrue() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Admin"));
        boolean result = roleStore.delete("1");
        assertThat(result).isTrue();
    }

    @Test
    void whenFindByIdThenAdmin() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Admin"));
        Role result = roleStore.findById("1");
        assertThat(result.getRole()).isEqualTo("Admin");
    }

    @Test
    void whenFindByIdThenIsNull() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Admin"));
        Role result = roleStore.findById("2");
        assertThat(result).isNull();
    }
}