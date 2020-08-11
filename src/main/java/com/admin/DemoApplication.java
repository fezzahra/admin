package com.admin;

import com.admin.Repository.ActivityRepository;
import com.admin.Repository.AdminRepository;
import com.admin.Repository.AgenceRepository;
import com.admin.Repository.VilleRepository;
import com.admin.models.Admin;
import com.admin.models.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner {

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

   @Autowired
	public AdminRepository adminRepository;

	@Autowired
	public VilleRepository villeRepository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder=new  BCryptPasswordEncoder();

	@Bean
	public HttpServletResponse servletResponse(){ return new HttpServletResponse() {
		@Override
		public void addCookie(Cookie cookie) {

		}

		@Override
		public boolean containsHeader(String name) {
			return false;
		}

		@Override
		public String encodeURL(String url) {
			return null;
		}

		@Override
		public String encodeRedirectURL(String url) {
			return null;
		}

		@Override
		public String encodeUrl(String url) {
			return null;
		}

		@Override
		public String encodeRedirectUrl(String url) {
			return null;
		}

		@Override
		public void sendError(int sc, String msg) throws IOException {

		}

		@Override
		public void sendError(int sc) throws IOException {

		}

		@Override
		public void sendRedirect(String location) throws IOException {

		}

		@Override
		public void setDateHeader(String name, long date) {

		}

		@Override
		public void addDateHeader(String name, long date) {

		}

		@Override
		public void setHeader(String name, String value) {

		}

		@Override
		public void addHeader(String name, String value) {

		}

		@Override
		public void setIntHeader(String name, int value) {

		}

		@Override
		public void addIntHeader(String name, int value) {

		}

		@Override
		public void setStatus(int sc) {

		}

		@Override
		public void setStatus(int sc, String sm) {

		}

		@Override
		public int getStatus() {
			return 0;
		}

		@Override
		public String getHeader(String name) {
			return null;
		}

		@Override
		public Collection<String> getHeaders(String name) {
			return null;
		}

		@Override
		public Collection<String> getHeaderNames() {
			return null;
		}

		@Override
		public String getCharacterEncoding() {
			return null;
		}

		@Override
		public String getContentType() {
			return null;
		}

		@Override
		public ServletOutputStream getOutputStream() throws IOException {
			return null;
		}

		@Override
		public PrintWriter getWriter() throws IOException {
			return null;
		}

		@Override
		public void setCharacterEncoding(String charset) {

		}

		@Override
		public void setContentLength(int len) {

		}

		@Override
		public void setContentLengthLong(long length) {

		}

		@Override
		public void setContentType(String type) {

		}

		@Override
		public void setBufferSize(int size) {

		}

		@Override
		public int getBufferSize() {
			return 0;
		}

		@Override
		public void flushBuffer() throws IOException {

		}

		@Override
		public void resetBuffer() {

		}

		@Override
		public boolean isCommitted() {
			return false;
		}

		@Override
		public void reset() {

		}

		@Override
		public void setLocale(Locale loc) {

		}

		@Override
		public Locale getLocale() {
			return null;
		}
	};}

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		ApplicationContext ctx =SpringApplication.run(DemoApplication.class, args);
		AgenceRepository agence=ctx.getBean(AgenceRepository.class);
		ActivityRepository activity=ctx.getBean(ActivityRepository.class);
		VilleRepository ville=ctx.getBean(VilleRepository.class);

	}


	@Override
	public void run(String... args) throws  Exception {

	//	adminRepository.save(new Admin((long)105,"Melloul","Yassir","EE45674","admin1@AFOIHebank.com",bCryptPasswordEncoder.encode("admin")));
	/*
		Ville c1 = new Ville("Salé");
		Ville c2 = new Ville("Meknes");
		Ville c3 = new Ville("Rabat");
		Ville c4 = new Ville("Oujda");
		Ville c5 = new Ville("Kenitra");
		Ville c6 = new Ville("Agadir");
		Ville c7= new Ville("Tetouan");
		Ville c8 = new Ville("Temara");
		Ville c9 = new Ville("Safi");
		Ville c10 = new Ville("Mohammedia");
		Ville c11= new Ville("Khouribga");
		Ville c12 = new Ville("El Jadida");
		Ville c13 = new Ville("Beni Mellal");
		Ville c14= new Ville("Ait Melloul");
		Ville c15= new Ville("Nador");
		Ville c16= new Ville("Dar Bouazza");
		Ville c17= new Ville("Taza");
		Ville c18= new Ville("Settat");
		Ville c19= new Ville("Berrechid");
		Ville c20= new Ville("Khemisset");
		Ville c21= new Ville("Inezgane");
		Ville c22= new Ville("Ksar El Kebir");
		Ville c23= new Ville("Larache");
		Ville c24= new Ville("Guelmim");
		Ville c25= new Ville("Khenifra");
		Ville c26= new Ville("Berkane");
		Ville c27= new Ville("Taourirt");
		Ville c28= new Ville("Bouskoura");
		Ville c29= new Ville("Fquih Ben Salah");
		Ville c30= new Ville("Oued Zem");
		Ville c31= new Ville("El Kelaa Des Sraghna");
		Ville c32= new Ville("Sidi Slimane");
		Ville c33= new Ville("Errachidia");
		Ville c34= new Ville("Guercif");
		Ville c35= new Ville("Oulad Teima");
		Ville c36= new Ville("Ben Guerir");
		Ville c37= new Ville("Tifelt");
		Ville c38= new Ville("Taroudant");
		Ville c39= new Ville("Sefrou");
		Ville c40= new Ville("Essaouira");
		Ville c41= new Ville("Fnideq");
		Ville c42= new Ville("Sidi Kacem");
		Ville c43= new Ville("Tiznit");
		Ville c44= new Ville("Tan-Tan");
		Ville c45= new Ville("Ouarzazate");
		Ville c46= new Ville("Youssoufia");
		Ville c47= new Ville("Martil");
		Ville c48= new Ville("Skhirat");
		Ville c49= new Ville("Ouazzane");
		Ville c50= new Ville("Benslimane");
		Ville c51= new Ville("Al Hoceima");
		Ville c52= new Ville("M'diq");
		Ville c53= new Ville("Midelt");
		Ville c54= new Ville("Azrou");
		Ville c55= new Ville("Marrakech");
		Ville c56= new Ville("Casablanca");
		Ville c57= new Ville("Fez");
		Ville c58= new Ville("Tangier");
		List<Ville> villes = Arrays.asList(c1, c2, c3, c4,c5,c6,c7,c8,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30,c31,c32,c33,c34,c35,c36
		,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50,c51,c52,c53,c54,c55,c56,c57,c58);
		villeRepository.saveAll(villes);
*/

	}
}


