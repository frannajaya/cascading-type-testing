# This repository will show you how cascade remove and persist works with (JPA Repository)

To see what happen and how things happen you can change in realtionship block code in ```Car``` entity
```aidl
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "steering_wheel_id")
    @Fetch(FetchMode.JOIN)
    private SteeringWheel steeringWheel;
```


at the one to one you can change the cascade then run the test related to cascade type you want to test.
for example type ```REMOVE```, you can delete the cascade type remove from the entity and run test ```CascadeRemoveTest``` and see the test will FAIL


next you add the cascade type ```REMOVE``` to the entity and run the test again and the test will PASS.


Thank you ~