package asda;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sloth.board.dao.AccountDao;
import com.sloth.board.dao.HostDAO;
import com.sloth.board.vo.AccountVO;
import com.sloth.board.vo.HostPicVO;
import com.sloth.board.vo.reserVO;

public class sss {
	@Test
	public void aaa() {
		AccountDao dao=new AccountDao();
		reserVO vo= new reserVO();
		
		
		List<reserVO> list =new ArrayList<reserVO>();
		
		list= dao.select_reser(vo);
		System.out.println(vo);
	}
}
