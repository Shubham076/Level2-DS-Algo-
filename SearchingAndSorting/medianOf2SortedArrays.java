//leetcode 4
class medianOf2SortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] merged = new int[nums1.length + nums2.length];
		int i = 0, j = 0, k = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				merged[k] = nums1[i];
				i++;
				k++;
			} else {
				merged[k] = nums2[j];
				j++;
				k++;
			}
		}
		while (j < nums2.length) {
			merged[k] = nums2[j];
			j++;
			k++;

		}
		while (i < nums1.length) {
			merged[k] = nums1[i];
			i++;
			k++;

		}
		double median = 0.0;
		int n = merged.length;
		int mid = n / 2;
		if(n % 2 == 0){
			 median = (merged[mid] + merged[mid - 1]) / 2.0;
		}
		else{
			median = merged[mid];
		}

		return median;
		}
	}