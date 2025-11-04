package com.kdedevelop.mediani.application.media.port.in.command;

import java.util.List;

public record MediaCreateCommand(long id, String type, String cover, String title, String description, String language, List<String> characterList, List<String> groupList, List<String> seriesList, List<String> tagList, List<String> creatorList, List<String> producerList) {
}
