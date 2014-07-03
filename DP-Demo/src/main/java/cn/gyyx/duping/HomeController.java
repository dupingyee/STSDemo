package cn.gyyx.duping;

import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gyyx.duping.entity.GameInfo;
import cn.gyyx.duping.entity.ServerInfo;
import cn.gyyx.duping.persistence.GameDao;
import cn.gyyx.duping.persistence.ServerDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private GameDao gameDao;
	private ServerDao serverDao;

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		gameDao = new GameDao();
		List<GameInfo> list = gameDao.queryList();

		model.addAttribute("gameList", list);
		return "list";
	}

	/*
	 * 根据游戏ID获取区服列表
	 */
	@RequestMapping(value = "/getServerList", method = RequestMethod.GET)
	public @ResponseBody List<ServerInfo> getServerList(
			@RequestParam("gameId") int gameId) {
		serverDao = new ServerDao();
		List<ServerInfo> list = serverDao.queryListByGameId(gameId);
		return list;
	}
}
