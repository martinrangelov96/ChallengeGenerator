package com.example.martoraneca.challengegenerator.data;

import java.util.List;

public interface DataSourceInterface {

    List<ListItem> getListOfData();

    ListItem createNewListItem();
}
