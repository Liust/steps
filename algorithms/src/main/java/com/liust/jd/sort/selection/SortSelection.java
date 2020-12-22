package com.liust.jd.sort.selection;

import com.liust.jd.sort.Data;
import com.liust.jd.sort.SortBase;
import com.liust.jd.utils.CheckUtil;
import com.liust.jd.utils.PrintUtil;

public class SortSelection extends SortBase {



    /**
     * selection doSort
     * eg: asc select the min num in rest nums of the array, then swap
     *  desc select the max num in rest nums of the array, then swap
     * selection doSort
     * 2: 20201222
     * 1
     *
     * time logic : O(n2)
     *
     * @param numbers
     * @param asc
     */

    @Override
    public void doSort(int[] numbers, boolean asc){

        version_20201222(numbers, asc);

    }

    /**
     * 2 - 42
     *
     * but when the CPL is equal to 0, the ds register must contain the Segment Selector of
     * the kernel data segment.
     * A similar situation occurs for the ss register. It must refer to a User Mode stack
     * inside the user data segment when the CPL is 3, and it must refer to a Kernel Mode
     * stack inside the kernel data segment when the CPL is 0. When switching from User
     * Mode to Kernel Mode, Linux always makes sure that the ss register contains the Segment
     * Selector of the kernel data segment.
     * When saving a pointer to an instruction or to a data structure, the kernel does not
     * need to store the Segment Selector component of the logical address, because the ss
     * register contains the current Segment Selector. As an example, when the kernel
     * invokes a function, it executes a call assembly language instruction specifying just
     * the Offset component of its logical address; the Segment Selector is implicitly 隐含地 selected
     * as the one referred to by the cs register. Because there is just one segment of type
     * “executable in Kernel Mode,” namely the code segment identified by __KERNEL_CS, it
     * is sufficient 足够，充足 to load __KERNEL_CS into cs whenever the CPU switches to Kernel Mode.
     * The same argument goes for pointers to kernel data structures (implicitly using the ds
     * register), as well as for pointers to user data structures (the kernel explicitly 明确地 uses the
     * es register).
     * Besides the four segments just described, Linux makes use of a few other specialized
     * segments. We’ll introduce them in the next section while describing the Linux GDT.
     *
     * The Linux GDT
     * In uniprocessor systems there is only one GDT, while in multiprocessor systems
     * there is one GDT for every CPU in the system. All GDTs are stored in the cpu_gdt_
     * table array, while the addresses and sizes of the GDTs (used when initializing the
     * gdtr registers) are stored in the cpu_gdt_descr array. If you look in the Source Code
     * Index, you can see that these symbols are defined in the file arch/i386/kernel/head.S.
     * Every macro, function, and other symbol in this book is listed in the Source Code
     * Index, so you can quickly find it in the source code.
     * The layout of the GDTs is shown schematically 示意地 in Figure 2-6. Each GDT includes 18
     * segment descriptors and 14 null, unused, or reserved entries. Unused entries are
     * inserted on purpose so that Segment Descriptors usually accessed together are kept
     * in the same 32-byte line of the hardware cache (see the section “Hardware Cache”
     * later in this chapter).
     * The 18 segment descriptors included in each GDT point to the following segments:
     * • Four user and kernel code and data segments (see previous section).
     * • A Task State Segment (TSS), different for each processor in the system. The linear
     * address space corresponding to a TSS is a small subset of the linear address
     * space corresponding to the kernel data segment. The Task State Segments are
     *
     * 44
     *
     *
     * sequentially stored in the init_tss array; in particular, the Base field of the TSS
     * descriptor for the nth CPU points to the nth component of the init_tss array.
     * The G (granularity) flag is cleared, while the Limit field is set to 0xeb, because the
     * TSS segment is 236 bytes long. The Type field is set to 9 or 11 (available 32-bit
     * TSS), and the DPL is set to 0, because processes in User Mode are not allowed to
     * access TSS segments. You will find details on how Linux uses TSSs in the section
     * “Task State Segment” in Chapter 3.
     * • A segment including the default Local Descriptor Table (LDT), usually shared by
     * all processes (see the next section).
     * • Three Thread-Local Storage (TLS) segments: this is a mechanism that allows
     * multithreaded applications to make use of up to three segments containing data
     * local to each thread. The set_thread_area() and get_thread_area() system calls,
     * respectively, create and release a TLS segment for the executing process.
     * • Three segments related to Advanced Power Management (APM): the BIOS code
     * makes use of segments, so when the Linux APM driver invokes BIOS functions to
     * get or set the status of APM devices, it may use custom code and data segments.
     * • Five segments related to Plug and Play (PnP) BIOS services. As in the previous
     * case, the BIOS code makes use of segments, so when the Linux PnP driver
     * invokes BIOS functions to detect the resources used by PnP devices, it may use
     * custom code and data segments.
     *
     * @param
     * @return
     */
    /**
     *
     * @param numbers
     * @param isAsc
     */
    public void version_20201222(int[] numbers, boolean isAsc){

        if(CheckUtil.isEmpty(numbers)){
            return;
        }

        for (int i = 0; i < numbers.length; i++) {

            for(int j=i+1; j<numbers.length; j++){
                if(numbers[j] < numbers[i] == isAsc){
                    swap(numbers, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        SortSelection sortSelection = new SortSelection();
        int[] nums = Data.getData();
        PrintUtil.println(nums);
        sortSelection.doSort(nums, false);
        PrintUtil.println(nums);
        sortSelection.doSort(nums, true);
        PrintUtil.println(nums);
    }


    /**
     *
     */
    private void firstVersion(int[] nums, boolean asc){
        if(!CheckUtil.needSort(nums)){
            return;
        }

        int minIndex = 0;
        for(int i=0; i< nums.length; i++){
            minIndex = i;
            for(int j=i+1; j<nums.length; j++){
                if(SortBase.needSwap(nums[minIndex], nums[j], asc)){
                    minIndex = j;
                }
            }
            CheckUtil.swap(nums, minIndex, i);
        }
    }
}
