package javabase.lean.io;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

/**
 * 监控文件
 * @author wei.w.zhou.integle.com
 * @copyright 2017年7月29日下午12:59:49
 */
public class WatchDirectory {

	public static void main(String[] args) throws IOException, InterruptedException {
		//1.创建watchService
		WatchService ws = FileSystems.getDefault().newWatchService();
		
		Path path = Paths.get("b");
		
		//2.注册watchService，并制定监听事件类型
		WatchKey register = path.register(ws, ENTRY_MODIFY, ENTRY_CREATE, ENTRY_DELETE);
		while (true) {
			//获取队列中key
			WatchKey key = ws.take();
			
			//获取key的事件
			for (WatchEvent<?> event : key.pollEvents()) {
				
				//获取事件类型
				Kind<?> kind = event.kind();
				
				if (kind == OVERFLOW) {
					continue;
				}
				
				WatchEvent<Path> ev = (WatchEvent<Path>) event;
				
				//获取事件的路径
				Path p = ev.context();
				
				System.out.format("%s 发生改变,事件类型：%s%n", path.resolve(p), kind);
			}
			
			//重置key的状态
			if (!key.reset()) {
				break;
			}
		}
	}
}
