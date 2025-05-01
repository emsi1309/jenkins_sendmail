package emsi.jenkins_test_build;

import emsi.jenkins_test_build.service.EmailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class JenkinsTestBuildApplication  implements CommandLineRunner{
	@Autowired
	private EmailService emailService;

	@Value("${mail.to}")
	private String to;

	@Value("${mail.subject}")
	private String subject;

	@Value("${mail.content}")
	private String content;
	public static void main(String[] args) {
		SpringApplication.run(JenkinsTestBuildApplication.class, args);
	}
	@Override
	public void run(String... args) {
		emailService.send(to, subject, content);
	}

}
