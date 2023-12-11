package org.dummy.restapi.modelos;

import java.util.List;

public class EmpleadoModel {
    private String name;
    private String salary;
    private String age;

    public EmpleadoModel(List<String> dataEmployee) {
            this.name = dataEmployee.get(0);
            this.salary = dataEmployee.get(1);
            this.age = dataEmployee.get(2);
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

}
