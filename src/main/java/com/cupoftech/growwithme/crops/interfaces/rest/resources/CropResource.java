package com.cupoftech.growwithme.crops.interfaces.rest.resources;

public record CropResource(
        Long id,
        String name,
        String code,
        String status,
        String cost
) { }
