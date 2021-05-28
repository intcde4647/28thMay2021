import java.util.List;

import com.dao.PackageDao;
import com.dao.PackageDaoImpl;
import com.model.Package1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PackageDao pd=new PackageDaoImpl();
		List<Package1>packages=pd.readFromFile();
		pd.writeToDatabase(packages);

	}

}
