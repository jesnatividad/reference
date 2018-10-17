import com.test.exception.TooLargeNumberException;
import com.test.service.impl.MathServiceImpl;
import org.junit.*;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Jes on 09/28/2018.
 */
public class MathServiceTest {

	MathServiceImpl mathService = new MathServiceImpl();

	@Before
	public void before(){
		System.out.println("BEFORE");
	}

	@After
	public void after(){
		System.out.println("AFTER");
	}

	@BeforeClass
	public static void beforeClass(){
		System.out.println("BEFORE CLASS");
	}

	@AfterClass
	public static void afterClass(){
		System.out.println("AFTER CLASS");
	}

	@Test

	public void sum_3_numbers(){

		Assert.assertEquals(6,mathService.sum(new int[]{1,2,3}));
		System.out.println("TEST SUCCESS!");
	}
}
