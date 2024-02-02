package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.report.adapters.JSONAdapter;
import ru.job4j.ood.srp.store.Store;
import java.util.function.Predicate;

public class JSONReport implements Report {
    private final Store store;

    public JSONReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Employee.class, new JSONAdapter());
        Gson gson = builder.setPrettyPrinting().create();
        return gson.toJson(store.findBy(filter));
    }
}
