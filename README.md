# Fakkit API

一个模仿Bukkit框架的Fabric Mod API

因为Fabric的很多东西太不优雅了，所以诞生了这个模仿Bukkit框架的FakkitAPI

逐渐完善中...

## Command 命令

Fabric,亦或说是Mojang的Brigadier太不优雅太难用了，所以让我们开写一个Fakkit Command吧！

**创建一个命令**

我们需要继承来自Fakkit的Command类，继承他，实现execute方法和构造方法。

```java
import com.gihub.zzz8y.fakkit.command.Command;
import com.gihub.zzz8y.fakkit.command.CommandSender;
import net.minecraft.text.Text;

public class ExampleCommand extends Command {
    public ExampleCommand() {
        super("example"); //命令字符串
    }
    
    @Override
    public boolean execute(CommandSender sender, String command, String[] args) {
        
        return false;
    }
}
```

让我们看一下，这里有一个超类super构造方法，这里面要填上你的命令字符串，些什么在mc里就是 `/什么` ，随便写。

`execute(CommandSender,String,Stirng[])` 方法是执行命令操作的方法，玩家输入命令你就可以在这里处理它。sender为命令发送者，他可以直接获取到，命令发送者的类型，比如 控制台或者命令方块(Console Or Command Block)，玩家(Player)，命令方块矿车(Command Minecart)，其他实体(Other Entity)。你还可以从这里获取一个SeverCommandSource，去进行操作。<u>*计划中日后替换为可转换为Player的类型，属于Enitity*</u>
