package org.opensrp.domain.postgres;

public class Settings {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column core.settings.id
     *
     * @mbg.generated Tue Sep 04 17:59:18 EAT 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column core.settings.json
     *
     * @mbg.generated Tue Sep 04 17:59:18 EAT 2018
     */
    private Object json;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column core.settings.id
     *
     * @return the value of core.settings.id
     *
     * @mbg.generated Tue Sep 04 17:59:18 EAT 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column core.settings.id
     *
     * @param id the value for core.settings.id
     *
     * @mbg.generated Tue Sep 04 17:59:18 EAT 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column core.settings.json
     *
     * @return the value of core.settings.json
     *
     * @mbg.generated Tue Sep 04 17:59:18 EAT 2018
     */
    public Object getJson() {
        return json;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column core.settings.json
     *
     * @param json the value for core.settings.json
     *
     * @mbg.generated Tue Sep 04 17:59:18 EAT 2018
     */
    public void setJson(Object json) {
        this.json = json;
    }
}