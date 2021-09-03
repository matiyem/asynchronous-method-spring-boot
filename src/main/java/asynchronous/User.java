package asynchronous;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * created by Atiye Mousavi
 * Date: 8/31/2021
 * Time: 8:23 AM
 */
@JsonIgnoreProperties(ignoreUnknown = true)//این annotation به این معنی است که پراپرتی هایی که در این کلاس لیست نشده است نادیده بگیرد
//اسپرینت با استفاده از کتابخانه jasckson json ریسپانس رابر روی این مدل مپ میکند
@Data
public class User {
    private String name;
    private String blog;

    @Override
    public String toString() {
        return "User [name=" + name + ", blog=" + blog + "]";
    }
}
