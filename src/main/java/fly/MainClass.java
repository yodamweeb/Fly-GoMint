package fly;

import io.gomint.plugin.*;

@Startup(StartupPriority.STARTUP)
@PluginName("Fly")
@Version(major = 0, minor = 1)
public class MainClass extends Plugin {

    @Override
    public void onInstall(){
        registerCommand(new FlyCommand(this));
    }
}
