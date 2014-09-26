package com.cuppafame.gwtresponsive.client.application.login;

import javax.inject.Inject;

import com.cuppafame.gwtresponsive.client.common.HasManyClickHandlers;
import com.cuppafame.gwtresponsive.client.common.HasManyEnabled;
import com.cuppafame.gwtresponsive.client.common.ResponsiveDialog;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PopupViewImpl;

public class LoginPopupView extends PopupViewImpl implements LoginPopupPresenter.MyView {
    public interface Binder extends UiBinder<Widget, LoginPopupView> {
    }

    @UiField ResponsiveDialog dialog;
    @UiField Button loginButton, cancelButton;
    
    @Inject
    LoginPopupView(EventBus eventBus, Binder uiBinder) {
    	super(eventBus);
        initWidget(uiBinder.createAndBindUi(this));
        
        
    }

	@Override
	public HasClickHandlers getLoginClick() {
		return new HasManyClickHandlers(loginButton, dialog.getOKHandler());
	}

	@Override
	public HasClickHandlers getCancelClick() {
		return new HasManyClickHandlers(cancelButton, dialog.getCancelHandler());
	}

	@Override
	public HasEnabled getLoginEnabled() {
		return new HasManyEnabled(loginButton, dialog.getOKEnabled());
	}
}