import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;


public class GeneratorSqlMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		   List<String> warnings = new ArrayList<String>();
		   boolean overwrite = true;
		   //指向逆向工程的配置文件
		   File configFile = new File("src/generatorConfig.xml");
		   //System.out.println("-----"+configFile.length());
		   ConfigurationParser cp = new ConfigurationParser(warnings);
		   MyBatisGenerator myBatisGenerator = null;
			try {
				   Configuration config = cp.parseConfiguration(configFile);
				   DefaultShellCallback callback = new DefaultShellCallback(overwrite);
				    myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
					myBatisGenerator.generate(null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
