package asda;

import java.util.List;

import org.junit.Test;

import com.sloth.board.dao.HostDAO;
import com.sloth.board.vo.HostVO;

public class sss {
	@Test
	public void aa() {
	HostDAO dao=new HostDAO();
	HostVO vo=new HostVO();
	List<HostVO> list = dao.SELECT_All(vo);
	System.out.println(list);
	}
}
