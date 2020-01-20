package com.example.designmodel.pattern.create.buildPattern;

/**
 * Created by hp on 2019/12/9.
 */
public class Builder {
    public Builder builder = null;

    public Builder() {

    }

    public class Build {
        private String name;
        private int age;

        public String getName() {
            return name == null ? "" : name;
        }

        public Builder setName(String name) {
            this.name = name;
            return Builder.this;
        }

        public int getAge() {
            return age;
        }

        public Builder setAge(int age) {
            this.age = age;
            return Builder.this;
        }
    }

}
