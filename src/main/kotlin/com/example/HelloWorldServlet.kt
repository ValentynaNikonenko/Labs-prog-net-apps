import jakarta.servlet.ServletException
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

@WebServlet(name = "HelloWorldServlet", value = ["/servlet"])
class HelloWorldServlet : HttpServlet() {

    @Throws(ServletException::class, IOException::class)
    override fun doPost(req: HttpServletRequest, res: HttpServletResponse) {

        servletContext.log("Request method: ${req.method}\n" +
                "Request Client IP: ${req.remoteAddr}\n" +
                "Request Params: ${req.parameterMap}\n" +
                "Request User-agent: ${req.getHeader("User-Agent")}")

        val key = req.getParameter("key")
        val value = req.getParameter("value").toInt()
        val test = req.getParameter("test").toBoolean()

        if (test) {
            res.contentType = "text/html"
            res.writer.println("<html><body><div>")
            res.writer.println("Request confirmed!")
            res.writer.println("</div></body></html>")
        } else {
            val timestamp = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())
            val line = "${key.repeat(value)}, $timestamp\n"
            val file = File("database.txt")
            FileWriter(file, true).use { it.write(line) }
            res.contentType = "text/html"
            res.writer.println("<html><body><div>")
            res.writer.println(file.readText())
            res.writer.println("</div></body></html>")
        }
    }
}