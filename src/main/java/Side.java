// The reason i am using the javax here is because the we have make the hibernate - ehcache dependecy in the pom.xml with same version , but there are no new version of the ehcache but jakarta only persitence with hibernate 6.x version , that why we have javax.


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)  // the readonly thingh make that data do not get changed.It makes sure that data is only for read.
public class Side                                   //It is best for static data that never changes (like country names or currency codes).
                                                    //If you try to update data marked as READ_ONLY, Hibernate will throw an exception.
{
    @Id
    @Column
    private int rool_Number;
    @Column
    private String Name;
    @Column
    private String Education;


    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getRool_Number() {
        return rool_Number;
    }

    public void setRool_Number(int rool_Number) {
        this.rool_Number = rool_Number;
    }

    public String toString()
    {
        return this.getEducation()+" "+this.getRool_Number()+" "+this.getName();
    }

}
