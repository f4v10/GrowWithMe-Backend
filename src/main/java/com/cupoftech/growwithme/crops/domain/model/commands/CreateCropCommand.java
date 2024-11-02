package com.cupoftech.growwithme.crops.domain.model.commands;

public record CreateCropCommand(String name, String code, String status, String cost) {
}
