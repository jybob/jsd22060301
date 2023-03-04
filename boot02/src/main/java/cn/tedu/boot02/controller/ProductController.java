package cn.tedu.boot02.controller;

import cn.tedu.boot02.entity.Product;
import cn.tedu.boot02.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductMapper mapper;


    @RequestMapping("/insert")
    @ResponseBody
    public String insert(Product product){
        System.out.println("product = " + product);
        mapper.insert(product);
        return "添加完成！<a href='/'>添加完成</a>";
    }


    @RequestMapping("/select")
    @ResponseBody
    public String select(){
       List<Product> list=mapper.select();
        String html = "<table border='1'>";
        html+="<caption>商品列表</caption>";
        html+="<tr><th>id</th><th>标题</th><th>价格</th><th>库存</th><th>操作</th></tr>";
        for (Product product:list) {
            html+="<tr>";
            html+="<td>"+product.getId()+"</td>";
            html+="<td>"+product.getTitle()+"</td>";
            html+="<td>"+product.getPrice()+"</td>";
            html+="<td>"+product.getNum()+"</td>";
            // ?是请求地址和请求参数的分隔符
            html+="<td><a href='/delete?id="+product.getId()+"'>删除</a></td>";
            html+="</tr>";
        }
        html+="</table>";
        return html;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(int id){
        mapper.deleteById(id);
        return "删除完成！<a href='/select'>返回列表页面</a>";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(Product product){
        mapper.update(product);
        return "修改完成！<a href='/'>返回首页</a>";
    }

}
