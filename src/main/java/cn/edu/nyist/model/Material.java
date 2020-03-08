package cn.edu.nyist.model;

public class Material {
    /**
     *  id
     */
    private Integer id;

    /**
     * 石头剩余量 stone
     */
    private Integer stone;

    /**
     * 沙子剩余量 sand
     */
    private Integer sand;

    /**
     * 水泥剩余量 cement
     */
    private Integer cement;

    /**
     * 添加剂剩余量 additive
     */
    private Integer additive;

    /**
     * 
     * @author typ
     * @date 2020-03-08 08:51:07
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @author typ
     * @date 2020-03-08 08:51:07
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 石头剩余量
     * @author typ
     * @date 2020-03-08 08:51:07
     * @return stone 石头剩余量
     */
    public Integer getStone() {
        return stone;
    }

    /**
     * 石头剩余量
     * @author typ
     * @date 2020-03-08 08:51:07
     * @param stone 石头剩余量
     */
    public void setStone(Integer stone) {
        this.stone = stone;
    }

    /**
     * 沙子剩余量
     * @author typ
     * @date 2020-03-08 08:51:07
     * @return sand 沙子剩余量
     */
    public Integer getSand() {
        return sand;
    }

    /**
     * 沙子剩余量
     * @author typ
     * @date 2020-03-08 08:51:07
     * @param sand 沙子剩余量
     */
    public void setSand(Integer sand) {
        this.sand = sand;
    }

    /**
     * 水泥剩余量
     * @author typ
     * @date 2020-03-08 08:51:07
     * @return cement 水泥剩余量
     */
    public Integer getCement() {
        return cement;
    }

    /**
     * 水泥剩余量
     * @author typ
     * @date 2020-03-08 08:51:07
     * @param cement 水泥剩余量
     */
    public void setCement(Integer cement) {
        this.cement = cement;
    }

    /**
     * 添加剂剩余量
     * @author typ
     * @date 2020-03-08 08:51:07
     * @return additive 添加剂剩余量
     */
    public Integer getAdditive() {
        return additive;
    }

    /**
     * 添加剂剩余量
     * @author typ
     * @date 2020-03-08 08:51:07
     * @param additive 添加剂剩余量
     */
    public void setAdditive(Integer additive) {
        this.additive = additive;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", stone=" + stone +
                ", sand=" + sand +
                ", cement=" + cement +
                ", additive=" + additive +
                '}';
    }
}