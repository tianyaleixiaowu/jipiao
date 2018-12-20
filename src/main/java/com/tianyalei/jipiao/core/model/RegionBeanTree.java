package com.tianyalei.jipiao.core.model;

import java.util.*;

public class RegionBeanTree {
    private String code;//id
    private String label;//名称
    private Byte leve;//等级
    private String panelname;//所属板块
    private List<RegionBeanTree> children = new ArrayList<>();

    private Map<String, RegionBeanTree> childMap = new LinkedHashMap<>();

    public RegionBeanTree(String code, String label, Byte leve,String panelname) {
        this.code = code;
        this.label = label;
        this.leve = leve;
        this.panelname = panelname;
    }

    public String getPanelname() {
        return panelname;
    }

    public void setPanelname(String panelname) {
        this.panelname = panelname;
    }

    public RegionBeanTree() {
    }

    public Byte getLeve() {
        return leve;
    }

    public void setLeve(Byte leve) {
        this.leve = leve;
    }
    public void setCode(String code) {
        this.code = code;
    }


    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<RegionBeanTree> getChildren() {
        return children;
    }

    public void setChildren(List<RegionBeanTree> children) {
        this.children = children;
    }

    /**
     *  转换树
     *  20->
     *      2020->
     *          202010->
     *              202020
     * @param rMap
     * @param n
     */
    public static void turnToMap(Map<String, RegionBeanTree> rMap, RegionBeanTree n) {
        List<String> keyList = new ArrayList<>();
        if(n.getLeve() > 2){
            keyList.add(n.getCode().substring(0, 2));
        }
        int code = code(n.getLeve());
        for (int i = 0; i < n.getCode().length() / code; i++) {// 组装code的父级结构
            String key = n.getCode().substring(0, code + (i * code));
            keyList.add(key);
        }

        Map<String, RegionBeanTree> tmpMap = rMap;
        String f = n.code;
        for (int i = 0; i < keyList.size(); i++) {
            String thisKey = keyList.get(i);
            RegionBeanTree tmpNode = tmpMap.get(thisKey);
            if (i + 1 == keyList.size()) {//thisList 只有1时创建临时变量。不存在父节点
                tmpMap.put(n.getCode(), n);// 如果是末级节点，则放入该节点
            } else {//存在父节点，创建一个容器
                tmpMap = tmpNode.childMap;// 如果不是末级节点，则将该节点赋值给临时变量
            }
        }
    }
    private static int code(Byte leve){
        if(leve == 1 || leve == 2){
            return 2;
        }else{
            return 4;
        }
    }

    /**
     * 获取树
     * @param rMap
     * @param rn
     */
    public static void turnToList(Map<String, RegionBeanTree> rMap, RegionBeanTree rn) {
        Set<Map.Entry<String, RegionBeanTree>> eSet = rMap.entrySet();
        Iterator<Map.Entry<String, RegionBeanTree>> mIt = eSet.iterator();
        while (mIt.hasNext()) {
            Map.Entry<String, RegionBeanTree> entry = mIt.next();
            RegionBeanTree node = entry.getValue();
            rn.children.add(node);
            turnToList(node.childMap, node);
        }
    }
  /* public static void main(String[] args) {
        RegionBeanTree node = new RegionBeanTree();//
        initTreeData(node);// 构建树前的初始化平铺数据，模拟数据库查询出的数据

        Map<String, RegionBeanTree> rMap = new LinkedHashMap<String, RegionBeanTree>();// 临时组织数据map

        for (RegionBeanTree thisN : node.children) {
            turnToMap(rMap, thisN);// 将平铺的数据，解析到map中，构建一颗逻辑树
        }

        RegionBeanTree root = new RegionBeanTree();// 结果树
        turnToList(rMap, root);// 递归解析map树，并放入root这个根节点中
        System.out.println(JSONObject.toJSONString(root));
        // root既是结果树


    }

    public RegionBeanTree(String code,String label,byte leve){
        this.code = code;
        this.label = label;
        this.leve = leve;
    }
    static void initTreeData(RegionBeanTree node) {


        *//*node.children.add(new RegionBeanTree("005","5.1层",new Byte("0")));
        node.children.add(new RegionBeanTree("005001","5.2层",new Byte("1")));
        node.children.add(new RegionBeanTree("005001002","5.3层",new Byte("2")));
        node.children.add(new RegionBeanTree("005001002001","5.4层",new Byte("3")));
        node.children.add(new RegionBeanTree("005001002002","5.4层",new Byte("3")));*//*



        node.children.add(new RegionBeanTree("20","1层",new Byte("1")));
        node.children.add(new RegionBeanTree("2081","2层",new Byte("2")));
        node.children.add(new RegionBeanTree("2082","2层",new Byte("2")));
        node.children.add(new RegionBeanTree("20811715","3层",new Byte("3")));
        node.children.add(new RegionBeanTree("208117151010","4层",new Byte("4")));
        node.children.add(new RegionBeanTree("208117151020","4层",new Byte("4")));
        node.children.add(new RegionBeanTree("2081171510101010","5层",new Byte("5")));

    }*/
}
