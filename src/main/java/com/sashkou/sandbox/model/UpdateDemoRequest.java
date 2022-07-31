package com.sashkou.sandbox.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateDemoRequest {
    @NotNull private String id;
    @NotNull private String name;
}
