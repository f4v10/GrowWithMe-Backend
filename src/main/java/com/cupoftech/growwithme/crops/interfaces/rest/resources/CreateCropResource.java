package com.cupoftech.growwithme.crops.interfaces.rest.resources;

public record CreateCropResource(
        String name,
        String code,
        String status,
        String cost
) { }
