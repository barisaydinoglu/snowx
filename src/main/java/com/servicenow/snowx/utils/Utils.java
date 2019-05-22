package com.servicenow.snowx.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import com.servicenow.snowx.exception.AppException;
import com.servicenow.snowx.model.HPShip;
import com.servicenow.snowx.model.HPTorpedo;
import com.servicenow.snowx.model.Matrix;
import com.servicenow.snowx.model.SnowX;
import com.servicenow.snowx.model.Target;
import com.servicenow.snowx.model.TargetMatrix;

public final class Utils {

	public static List<Target> analysis(final SnowX snowX, final HPShip ship, final HPTorpedo torpedo)
			throws AppException {
		final PriorityQueue<Target> allTargets = Utils.getEmptyResultQueue();
		allTargets.addAll(Utils.searchPattern(snowX, ship, 0.5));
		allTargets.addAll(Utils.searchPattern(snowX, torpedo, 0.5));
		return Utils.filterResults(allTargets);
	}

	public static int applyConvolution(final char[][] input, final int x, final int y, final char[][] k,
			final int kernelWidth, final int kernelHeight) {
		int output = 0;
		for (int xi = 0; xi < kernelWidth; ++xi) {
			for (int yi = 0; yi < kernelHeight; ++yi) {
				if (input[y + yi][x + xi] == k[yi][xi]) {
					output++;
				}
			}
		}
		return output;
	}

	private static List<Target> filterResults(final PriorityQueue<Target> allTargets) {
		final List<Target> filteredTargets = new ArrayList<>();
		final int maxCount = 10;
		for (int i = 0; (i < maxCount) && !allTargets.isEmpty(); ++i) {
			filteredTargets.add(0, allTargets.poll());
		}
		return filteredTargets;
	}

	public static PriorityQueue<Target> getEmptyResultQueue() {
		return new PriorityQueue<>((o1, o2) -> Double.compare(o2.getConfidence(), o1.getConfidence()));
	}

	public static List<Target> searchPattern(final Matrix bigMatrix, final TargetMatrix targetMatrix,
			final double minSimilarity) throws AppException {
		final int maxScore = targetMatrix.getRowCount() * targetMatrix.getColumnCount();
		final double minScore = maxScore * minSimilarity;
		final PriorityQueue<Target> resultQueue = Utils.getEmptyResultQueue();
		for (int xi = 0; xi <= (bigMatrix.getColumnCount() - targetMatrix.getColumnCount()); ++xi) {
			for (int yi = 0; yi <= (bigMatrix.getRowCount() - targetMatrix.getRowCount()); ++yi) {
				final int score = Utils.applyConvolution(bigMatrix.getData(), xi, yi, targetMatrix.getData(),
						targetMatrix.getColumnCount(), targetMatrix.getRowCount());
				if (score > minScore) {
					final double similarity = (double) score / maxScore;
					resultQueue.add(new Target(xi, yi, similarity, targetMatrix.getType()));
				}
			}
		}
		return Utils.filterResults(resultQueue);
	}

	private Utils() {
	}

}
