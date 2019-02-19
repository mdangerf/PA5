import java.util.Scanner;

public class FullText {

	public static void main(String[] args) {

		/*
		 * System.out.print("Enter a URL: ");
		 * 
		 * @SuppressWarnings("resource") String URLString = new
		 * Scanner(System.in).next();
		 */

		String URLString = "https://en.wikipedia.org/wiki/Citadel";

		try {

			java.net.URL url = new java.net.URL(URLString);
			@SuppressWarnings("resource")
			Scanner input = new Scanner(url.openStream());

			String line = "";
			String refLinksOL = "";

			while (input.hasNext()) {
				line += input.nextLine();
			}

			String[] refLinks = refLinksOL.split("<a[\\s]+([^>]+)>");

			/* Reference Links Orginized List - Dangerfield */
			refLinksOL += line.substring(line.indexOf("<ol class=\"references\">"), line.indexOf("</ol>") + 4);
//			System.out.println(refLinksOL);

			/* Removes JavaScript - Dangerfield */
			String target = line.replaceAll("<script[^>]*[^>]*>(.*?)</script>", " ").replaceAll("\\s+", " ").trim();

			/* Removes HTML Tags - Dangerfield */
			String body = target.replaceAll("<[^>]*>", " ").replaceAll("\\s+", " ").trim();
//			System.out.println(body);

		} catch (java.net.MalformedURLException ex) {
			System.out.println("Invalid URL");
		} catch (java.io.IOException ex) {
			System.out.println("IO Errors");
		}

	}
}
