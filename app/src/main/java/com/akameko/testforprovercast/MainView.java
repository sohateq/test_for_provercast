package com.akameko.testforprovercast;

import com.akameko.testforprovercast.repository.pojos.Item;

import java.util.List;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(value = AddToEndSingleStrategy.class)
public interface MainView extends MvpView {
    void updateRecycler(List<Item> siteListItem);
    void updateDatabase(List<Item> siteListItem);
}
