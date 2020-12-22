package com.liust.jd.sort.insert;

import com.liust.jd.sort.SortBase;

public class SortInsertion extends SortBase {

    /**
     *
     * @param nums
     * @param isAsc
     */

    public void firstVersion(int[] nums, boolean isAsc) {
        if(!needSort(nums)){
            return;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if(needSwap(nums[j], nums[j+1], isAsc)){
                    swap(nums, j, j+1);
                }
            }
        }
    }

    /**
     *  second time version
     * @param numbers
     * @param isAsc
     */

    /**
     * 1 - 41
     *
     *
     * Segmentation in Linux
     * Segmentation has been included in 80 × 86 microprocessors to encourage programmers
     * to split their applications into logically related entities, such as subroutines 子程序 or
     * global and local data areas. However, Linux uses segmentation in a very limited way.
     * In fact, segmentation and paging are somewhat redundant 有些冗余, because both can be used
     *
     * to separate the physical address spaces of processes: segmentation can assign a different
     * linear address space to each process, while paging can map the same linear
     * address space into different physical address spaces. Linux prefers paging to segmentation
     * for the following reasons:
     * • Memory management is simpler when all processes use the same segment register
     * values—that is, when they share the same set of linear addresses.
     * • One of the design objectives of Linux is portability 可移植性的 to a wide range of architectures;
     * RISC architectures in particular 特定 have limited support for segmentation.
     * The 2.6 version of Linux uses segmentation only when required by the 80 × 86 architecture.
     * All Linux processes running in User Mode use the same pair of segments to address
     * instructions and data. These segments are called user code segment and user data segment,
     * respectively. Similarly, all Linux processes running in Kernel Mode use the
     * same pair of segments to address instructions and data: they are called kernel code
     * segment and kernel data segment, respectively. Table 2-3 shows the values of the Segment
     * Descriptor fields for these four crucial segments.
     *
     * The corresponding Segment Selectors are defined by the macros _ _USER_CS, _ _USER_DS,
     * _ _KERNEL_CS, and _ _KERNEL_DS, respectively. To address the kernel code segment, for
     * instance, the kernel just loads the value yielded 产生 by the _ _KERNEL_CS macro into the cs
     * segmentation register.
     * Notice that the linear addresses associated 关联 with such segments all start at 0 and reach
     * the addressing limit of 232 –1. This means that all processes, either in User Mode or
     * in Kernel Mode, may use the same logical addresses.
     * Another important consequence 意义 of having all segments start at 0x00000000 is that in
     * Linux, logical addresses coincide with linear addresses; that is, the value of the Offset
     * field of a logical address always coincides with the value of the corresponding linear
     * address.
     * As stated 陈述 earlier, the Current Privilege Level of the CPU indicates whether the processor
     * is in User or Kernel Mode and is specified by the RPL field of the Segment Selector
     * stored in the cs register. Whenever the CPL is changed, some segmentation registers
     * must be correspondingly updated. For instance, when the CPL is equal to 3 (User
     * Mode), the ds register must contain the Segment Selector of the user data segment,
     *
     * @param numbers
     * @return
     */

    private void version_20201222(int[] numbers, boolean isAsc){
        for (int i = 1; i < numbers.length; i++) {
            for(int j = i; j > 0; j--){
                if(numbers[j] < numbers[j-1] == isAsc){
                    swap(numbers, j, j-1);
                }
            }
        }
    }

    /**
     *
     * insert sort
     * time logic: O(n2)
     *
     * 2:20201222
     *
     * @param numbers
     * @param isAsc
     */

    @Override
    public void doSort(int[] numbers, boolean isAsc) {
        version_20201222(numbers, isAsc);
    }







}
