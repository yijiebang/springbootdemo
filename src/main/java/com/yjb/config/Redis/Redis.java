package com.yjb.config.Redis;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * redis
 * 通过jedis连接redis
 * cmd设置redis的密码：              config set requirepass "root"
 */
public class Redis {

    /**
     * 有密码验证
     */
    public static Jedis setJedis() {
        Jedis  jedis;
        //连接redis服务器(在这里是连接本地的)
        jedis = new Jedis("127.0.0.1", 6379);
        //权限认证
        jedis.auth("root");
        System.out.println("连接服务成功");
        return jedis;
    }

    public static void String(Jedis  jedis) {
/* //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
*/
        //设置 redis 字符串数据
        jedis.set("runoobkey", "www.runoob.com");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));
    }
    /***
     * Redis Java List(列表) 实例
     * 传入Jedis连接信息
     * @param jedis
     */
    public static void List(Jedis  jedis){
        /* //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
*/
        //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        jedis.lpush("site-list", "yjb");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }
    }

    /**
     * Redis Java Keys 实例
     * 传入Jedis连接信息
     * @param jedis
     */
    public static void Set(Jedis  jedis) {
       /* //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
*/      jedis.del("key");//删除key
        // 获取数据并输出
        Set<String> keys = jedis.keys("*");
        Iterator<String> it=keys.iterator() ;
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }
    }
        public static void main(String[] args) {
            Jedis  jedis=  setJedis();//打开连接
             String(jedis);
             List(jedis);
            Set(jedis);
            jedis.quit();//关闭连接
        }

}
