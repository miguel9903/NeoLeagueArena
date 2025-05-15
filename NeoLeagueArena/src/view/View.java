package view;

import view.modules.login.LoginWindow;
import view.modules.signup.RegisterWindow;
import view.windows.MainWindow;

public class View {
	
	LoginWindow loginWindow;
	RegisterWindow registerWindow;
	MainWindow mainWindow;
	
	public View() {
		loginWindow = new LoginWindow();
		registerWindow = new RegisterWindow();
		mainWindow = new MainWindow();
	}
	
	public LoginWindow getLoginWindow() {
		return loginWindow;
	}
	
	public void setLoginWindow(LoginWindow loginWindow) {
		this.loginWindow = loginWindow;
	}
	
	public RegisterWindow getRegisterWindow() {
		return registerWindow;
	}
	
	public void setRegisterWindow(RegisterWindow registerWindow) {
		this.registerWindow = registerWindow;
	}
	
	public MainWindow getMainWindow() {
		return mainWindow;
	}
	
	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}
	
}
