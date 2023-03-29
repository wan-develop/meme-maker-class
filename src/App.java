import java.net.URL;
import java.io.InputStream;

public class App {

    public static void main(String[] args) throws Exception {
 
        String baseUrl = "https://preview.redd.it/hf8bkyc4rgb51.jpg?width=640&crop=smart&auto=webp&v=enabled&s=8c2b875317ccc9fffac49a1398385c21e0018229";
        InputStream image = new URL(baseUrl).openStream();

        MemeMaker.create(image, "Download", "Baixar", "novoMeme");
    }
}
