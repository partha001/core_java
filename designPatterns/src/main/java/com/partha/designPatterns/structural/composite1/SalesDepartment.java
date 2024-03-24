package com.partha.designPatterns.structural.composite1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalesDepartment implements  Department{

    private Integer id;
    private String name;

    @Override
    public void printDepartmentName() {
        System.out.println(getClass().getSimpleName());
    }

}
