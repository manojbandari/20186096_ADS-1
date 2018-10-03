/**
 * Class for team details.
 */
class Team implements Comparable<Team> {
    /**
     * { var_description }
     */
    private String name;
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_valu
e }
     */
    public String getname() {
        return name;
    }
    /**
     * { function_description }
     *
     * @param      name  The name
     */
    public void setname(String name) {
        this.name = name;
    }
    /**
     * { var_description }.
     */
    private int wins;
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int getwins() {
        return wins;
    }

    /**
     * { function_description }
     *
     * @param      wins  The wins
     */
    public void setwins(int wins) {
        this.wins = wins;
    }
    /**
     * { var_description }
     */
    private int loss;

    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int getloss() {
        return loss;
    }

    /**
     * { function_description }
     *
     * @param      loss  The loss
     */
    public void setloss(int loss) {
        this.loss = loss;
    }
    /**
     * { var_description }.
     */
    private int draw;

    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int getdraw() {
        return draw;
    }

    /**
     * { function_description }
     *
     * @param      draw  The draw
     */
    public void setdraw(int draw) {
        this.draw = draw;
    }
    /**
     * Constructs the object.
     *
     * @param      nm    { parameter_description }
     * @param      w     { parameter_description }
     * @param      l     { parameter_description }
     * @param      d     { parameter_description }
     */
    public Team(String nm, int w, int l, int d) {
        this.name = nm;
        this.wins = w;
        this.loss = l;
        this.draw = d;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.name;
    }
    /**
     * { function_description }
     *
     * @param      ptd   The ptd
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(Team ptd) {
        if (this.getwins() > ptd.getwins()) {
            return 1;
        } else if (this.getwins() < ptd.getwins()) {
            return -1;
        } else if (this.getloss() < ptd.getloss()) {
            return 1;
        } else if (this.getloss() > ptd.getloss()) {
            return -1;
        } else if (this.getdraw() > ptd.getdraw()) {
            return 1;
        } else if (this.getdraw() < ptd.getdraw()) {
            return -1;
        } else {
            return 0;
        }

    }

}